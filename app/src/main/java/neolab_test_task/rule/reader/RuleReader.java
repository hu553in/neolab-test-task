package neolab_test_task.rule.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import neolab_test_task.rule.Rule;

public class RuleReader {
    private RuleReader() {}

    public static List<Rule> read(final Path path) throws RuleReaderException {
        final var objectMapper = new ObjectMapper();
        try (final var reader = Files.newBufferedReader(path)) {
            return objectMapper.readValue(
                reader,
                new TypeReference<List<Rule>>() {}
            );
        } catch (JsonParseException e) {
            throw new RuleReaderException("Unable to parse rules", e);
        } catch (JsonMappingException e) {
            throw new RuleReaderException("Unable to map rules", e);
        } catch (IOException e) {
            throw new RuleReaderException("Unable to read rules", e);
        }
    }
}
