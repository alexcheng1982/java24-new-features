package io.github.alexcheng1982.java24;

public class ScopedValues {
  private static final ScopedValue<String> V1 = ScopedValue.newInstance();
  private static final ScopedValue<String> V2  = ScopedValue.newInstance();

  void use() {
    var value = ScopedValue.where(V1, "Hello")
        .call(() -> V1.get().toUpperCase());
    System.out.println(value);
    ScopedValue.where(V1, "World")
        .run(() -> System.out.println(V1.get()));
    value = ScopedValue.where(V1, "Test")
        .where(V2, "Again")
        .call(() -> V1.get() + " " + V2.get());
    System.out.println(value);
  }

  public static void main(String[] args) {
    new ScopedValues().use();
  }
}
