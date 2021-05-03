# Discord.jar
A small robust Discord API Wrapper








### Examples

---

**Getting Started**

```java
public class Main {
    
    DJAR djar = new DJARImpl();
    private static final String BOT_TOKEN = "EXAMPLE_BOT_TOKEN";
    
    public static void main(String[] args) {
        djar.build(BOT_TOKEN);
    }
}
```