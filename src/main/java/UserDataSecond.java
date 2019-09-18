public class UserDataSecond {
    public Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data dataObject) {
        this.data = dataObject;
    }

    public class Data {
        private int id;
        private String name;
        private int year;
        private String color;
        private String pantone_value;

        // Getter Methods

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        public String getColor() {
            return color;
        }

        public String getPantone_value() {
            return pantone_value;
        }

        // Setter Methods

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setPantone_value(String pantone_value) {
            this.pantone_value = pantone_value;
        }
    }
}