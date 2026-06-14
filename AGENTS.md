# Repository Guidelines

## Project Structure & Module Organization

This is a multi-module Maven project for the `zheng` Java enterprise stack. The root `pom.xml` aggregates modules such as `zheng-common`, `zheng-upms`, `zheng-cms`, `zheng-pay`, `zheng-ucenter`, `zheng-api`, `zheng-message`, and `zheng-demo`. Java code follows the standard Maven layout: `src/main/java`, `src/main/resources`, and `src/test/java`. Web applications keep JSPs and descriptors under `src/main/webapp`, including `WEB-INF/jsp` and `WEB-INF/web.xml`. Admin/static assets live mainly in `zheng-admin/src` and webapp `resources` folders. SQL and data models are in `project-datamodel`; bootstrap diagrams/docs are in `project-bootstrap`; helper scripts are in `project-tools`.

## Build, Test, and Development Commands

- `mvn clean install`: builds all modules from the repository root and runs tests.
- `mvn test`: runs the Maven test phase for the full reactor.
- `mvn -pl zheng-upms -am test`: tests one module and any required upstream modules.
- `mvn -pl zheng-api/zheng-api-server -am package`: packages a specific web module and its dependencies.

The project targets Java 7 in Maven, while CI uses JDK 8. Use a compatible JDK and Maven installation before building.

## Coding Style & Naming Conventions

Use UTF-8 files and keep Java source compatible with Java 7. Match packages under `com.zheng.<module>`. Java classes use `PascalCase`; methods, fields, and Spring bean IDs use `camelCase`; constants use `UPPER_SNAKE_CASE`. Preserve layered names: `*Controller`, `*Service`, `*ServiceImpl`, `*Mapper`, `*Mock`, and MyBatis `*Mapper.xml`. Keep indentation consistent with nearby Java, XML, properties, and JSP files; do not reformat generated DAO/model code unless regenerating it.

## Testing Guidelines

Tests use Maven's standard lifecycle with JUnit-style classes under `src/test/java`. Name new tests `*Test.java` and place them beside the module they exercise, for example `zheng-upms/zheng-upms-rpc-service/src/test/java/.../UpmsServiceTest.java`. Prefer module-scoped runs while developing, then run `mvn test` or `mvn clean install` before broad changes. Note any tests skipped because they require MySQL, Redis, ZooKeeper, ActiveMQ, or Dubbo providers.

## Commit & Pull Request Guidelines

Recent history is mixed, including short Chinese descriptions and occasional `fix:` prefixes. Use concise imperative commit subjects, preferably scoped when useful, such as `fix: update UPMS session handling` or `docs: refresh bootstrap notes`. Pull requests should describe the changed modules, list verification commands, mention required configuration or data migrations, and include screenshots for JSP/admin UI changes. Link related issues when available.

## Security & Configuration Tips

Do not commit real credentials, production endpoints, or private keys. Environment-specific files are commonly under `src/main/resources/profiles`, `jdbc.properties`, `redis.properties`, and `config.properties`; keep local overrides out of commits unless they are sanitized examples.
