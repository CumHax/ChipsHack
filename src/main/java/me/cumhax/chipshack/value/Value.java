package  me.cumhax.chipshack.value;

import com.google.gson.JsonElement;

public class Value<T> {

    private final String label;
    private T value;
    private T min, max;

    public Value(String label, T value) {
        this.label = label;
        this.value = value;
    }

    public Value(String label, T value, T min, T max) {
        this.label = label;
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public void setValue(T value) {
        if (max != null && min != null) {

            if (((Number) min).floatValue() > ((Number) value).floatValue()) {
                value = min;
            }

            if (((Number) max).floatValue() < ((Number) value).floatValue()) {
                value = max;
            }

        }
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public T getValue() {
        return value;
    }

    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }

    public String getFixedValue() {
        Enum value = (Enum) this.value;
        return value.name().charAt(0) + value.name().toLowerCase().replaceFirst(Character.toString(value.name().charAt(0)).toLowerCase(), "");
    }

    public void setValueString(String value) {
        Enum[] array;
        for (int length = (array = ((Enum) getValue()).getClass().getEnumConstants()).length, i = 0; i < length; i++) {
            if (array[i].name().equalsIgnoreCase(value)) {
                this.value = (T) array[i];
            }
        }
    }

    public String getType() {
        if (value instanceof Enum) {
            return "Enum";
        }
        return value.getClass().getSimpleName();
    }

    public void setValueFromJson(Value setting, JsonElement element) {
        switch (setting.getType()) {
            case "Boolean":
                setting.setValue(element.getAsBoolean());
                break;
            case "Double":
                setting.setValue(element.getAsDouble());
                break;
            case "Float":
                setting.setValue(element.getAsFloat());
                break;
            case "Integer":
                setting.setValue(element.getAsInt());
                break;
            case "String":
                String str = element.getAsString();
                setting.setValue(str.replace("_", " "));
                break;
            case "Enum":
                setValueString(element.getAsString());
                break;
            default:
                throw new RuntimeException("Damn");
        }
    }

    public void increment() {
        Enum[] array;
        for (int length = (array = ((Enum) getValue()).getClass().getEnumConstants()).length, i = 0; i < length; i++) {
            if (array[i].name().equalsIgnoreCase(getFixedValue())) {
                i++;
                if (i > array.length - 1) {
                    i = 0;
                }
                setValueString(array[i].toString());
            }
        }
    }

    public void decrement() {
        Enum[] array;
        for (int length = (array = ((Enum) getValue()).getClass().getEnumConstants()).length, i = 0; i < length; i++) {
            if (array[i].name().equalsIgnoreCase(getFixedValue())) {
                i--;
                if (i < 0) {
                    i =  array.length - 1;
                }
                setValueString(array[i].toString());
            }
        }
    }

}
