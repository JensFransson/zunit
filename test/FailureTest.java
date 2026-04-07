void main() {
    var expected = "Hello, World!";
    var actual = "Hello, zunit!";

    assert Objects.equals(expected, actual) : "expected '%s' but got '%s'".formatted(expected, actual);
}
