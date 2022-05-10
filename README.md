# NEOLAB test task

## Description

This project is the app for counting statistics on specified entities
using specified rules.

## Input data (with example)

Entities are read from `.csv` file, rules are read from `.json` file.\
You can see the example of such files in `./example` directory.

## How to run

1. Install OpenJDK (≥ 11)
2. Run `./gradlew clean installShadowDist`
3. Run `java -jar ./app/build/install/app-shadow/lib/app-all.jar <entities_path> <rules_path>`
(you must replace `<entities_path>` and `<rules_path>` with paths to corresponding files)
