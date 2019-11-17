package ua.edu.ucu;

class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Student)) {
            return false;
        }
        Student comparee = (Student) obj;
        // if (comparee.hashCode() != this.hashCode())
        // {
        // return false;
        // }
        return comparee.GPA == this.GPA && this.year == comparee.year && this.surname.equals(comparee.surname)
                && this.name.equals(comparee.name);

    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        //super.hashCode();

        return (this.name.hashCode() + this.surname.hashCode() + ((int) this.getGPA() + this.getYear())*31) % 1031;
    }

}
