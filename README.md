# zunit

Zero-dependency, single-file Java test runner. Discovers `*Test.java` source files and runs each directly via `java --source 25` in a separate process. No compilation step, no JUnit, no build tool required — just run zunit and go. Each test gets its own JVM — full execution isolation with zero shared state.

![zunit](zunit.png)

## Test Convention

- **Test files**: name ends with `Test.java`
- Each file is a self-contained Java source script with `void main()`
- **Execution isolation**: each test runs in its own JVM process — no shared state, no interference between tests
- Failure: any thrown exception or non-zero exit = failed

Example test:

```java
import java.util.Objects;

void main() {
    var greeting = Greeter.greet("World");
    assert Objects.equals("Hello, World!", greeting) : "expected 'Hello, World!' but got: " + greeting;
}
```

## Usage

```
zunit [options]
```

### Options

| Option | Description |
|---|---|
| `-help` | Show help |
| `-cp:<path>` | Override classpath for main classes |
| `-tp:<path>` | Override test source path |
| `-verbose` | Show debug info |

### Test Source Auto-Detection

1. `src/test/java/` — Maven layout
2. `test/` — simple layout
3. `.` — fallback

### Classpath Auto-Detection

1. `.zb` config (`jar.dir` + `jar.file.name`) — zb configuration
2. `zbo/app.jar` — zb default
3. `target/classes` — Maven output
4. `classes/` — simple layout
5. `.` — fallback

### Examples

```bash
zunit                                # auto-detect and run all tests
zunit -cp:zbo/app.jar               # explicit classpath
zunit -tp:test/                      # explicit test source path
zunit -verbose                       # show debug output
```

## zb Integration

```bash
zb && zunit
```

zunit reads the `.zb` configuration file (if present) to resolve the JAR path from `jar.dir` and `jar.file.name`. Falls back to `zbo/app.jar` if `.zb` is absent.

## AI Skill

A [zunit skill](https://github.com/AdamBien/airails/tree/main/java/zunit) is available for AI-assisted generation and execution of zunit tests.

## References

- [bce.design](https://bce.design) — Boundary-Control-Entity architecture
- [zcl](https://github.com/AdamBien/zcl) — Zero-dependency Colour Logger
- [zcfg](https://github.com/AdamBien/zcfg) — Zero-dependency Configuration Utility
- [zb](https://github.com/AdamBien/zb) — Zero-dependency Builder
- [airails.dev](https://airails.dev) — AI-powered Development
