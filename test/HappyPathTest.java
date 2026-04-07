void main() {
    var result = 2 + 2;
    assert Objects.equals(result, 4) : "expected 4 but got " + result;

    var greeting = "Hello, %s!".formatted("zunit");
    assert greeting.contains("zunit") : "expected 'zunit' in: " + greeting;

    var items = java.util.List.of("a", "b", "c");
    assert Objects.equals(items.size(), 3) : "expected 3 items but got " + items.size();
}
