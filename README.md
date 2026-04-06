# zunit

Zero-dependency, single-file Java test runner. Discovers test classes on the classpath and executes all public void methods via reflection. No JUnit required, no downloads, no build tool — just run zunit and go.

## Test Convention

- **Test classes**: name ends with `Test`, public no-arg constructor
- **Test methods**: `public void`, zero arguments
- **Lifecycle**: `setUp()` called before each test, `tearDown()` after (optional)
- **Failure**: any thrown exception marks the test as failed

## Usage

```
zunit [options]
```

### Options

| Option | Description |
|---|---|
| `-help` | Show help |
| `-cp:<path>` | Override classpath (colon-separated) |
| `-verbose` | Show debug info |

### Classpath Auto-Detection

zunit detects your project layout automatically (in order):

1. `target/test-classes` + `target/classes` — Maven
2. `classes/` — simple layout
3. `.` — fallback

### Examples

```bash
zunit                                # auto-detect and run all tests
zunit -cp:target/test-classes        # explicit classpath
zunit -verbose                       # show debug output
```

## References

- [bce.design](https://bce.design) — Boundary-Control-Entity architecture
- [zcl](https://github.com/AdamBien/zcl) — Zero-dependency Colour Logger
- [zcfg](https://github.com/AdamBien/zcfg) — Zero-dependency Configuration Utility
- [zb](https://github.com/AdamBien/zb) — Zero-dependency Builder
