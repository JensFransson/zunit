# zunit

Zero-dependency, single-file Java script that downloads the JUnit Platform Console Standalone JAR from Maven Central, caches it locally, auto-detects your classpath (Maven, Gradle, or simple layouts), and runs all tests. No build tool required — just run zunit and go.

## Usage

```
zunit [options] [-- junit-args...]
```

### Options

| Option | Description |
|---|---|
| `-help` | Show help |
| `-version:<ver>` | JUnit version (default: 1.12.2) |
| `-cp:<path>` | Override classpath (colon-separated) |
| `-verbose` | Show download progress and debug info |

Everything after `--` is passed directly to the JUnit Console Launcher.

### Classpath Auto-Detection

zunit detects your project layout automatically (in order):

1. `target/test-classes` + `target/classes` — Maven
2. `build/classes/java/test` + `build/classes/java/main` — Gradle
3. `classes/` — simple layout
4. `.` — fallback

### Examples

```bash
zunit                                # auto-detect and run all tests
zunit -cp:target/test-classes        # explicit classpath
zunit -version:1.11.2                # use specific JUnit version
zunit -verbose                       # show debug output
zunit -- --include-tag=fast          # filter by tag
zunit -- --fail-if-no-tests          # fail if no tests found
```

### Cache

The JUnit Console Standalone JAR is downloaded once and cached in `~/.zunit/`.
