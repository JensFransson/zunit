# zunit

Zero-dependency, single-file Java test runner. Discovers `*Test.java` source files and runs each directly via `java --source 25`. No compilation step, no JUnit, no build tool required — just run zunit and go.

## Test Convention

- **Test files**: name ends with `Test.java`
- Each file is a self-contained Java source script with `void main()`
- Failure: any thrown exception or non-zero exit = failed

Example test:

```java
void main() {
    var greeting = Greeter.greet("World");
    if (!"Hello, World!".equals(greeting))
        throw new AssertionError("expected 'Hello, World!' but got: " + greeting);
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

1. `zbo/app.jar` — zb output
2. `target/classes` — Maven output
3. `classes/` — simple layout
4. `.` — fallback

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

zunit auto-detects `zbo/app.jar` and test files in `test/`.

## References

- [bce.design](https://bce.design) — Boundary-Control-Entity architecture
- [zcl](https://github.com/AdamBien/zcl) — Zero-dependency Colour Logger
- [zcfg](https://github.com/AdamBien/zcfg) — Zero-dependency Configuration Utility
- [zb](https://github.com/AdamBien/zb) — Zero-dependency Builder
