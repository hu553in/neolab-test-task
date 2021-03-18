package neolab_test_task.entity_reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

public class EntityReader {
    private EntityReader() {}

    public static List<Map<String, String>> read(final Path path)
        throws EntityReaderException {
        try (final var reader = Files.newBufferedReader(path)) {
            final var result = new ArrayList<Map<String, String>>();
            try (final var csvReader = new CSVReaderHeaderAware(reader)) {
                Map<String, String> next;
                while ((next = csvReader.readMap()) != null) {
                    result.add(next);
                }
                return result;
            }
        } catch (CsvValidationException e) {
            throw new EntityReaderException("Unable to validate CSV", e);
        } catch (IOException e) {
            throw new EntityReaderException("Unable to read entities", e);
        }
    }
}
