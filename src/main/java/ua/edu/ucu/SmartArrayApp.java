package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.FilterDecorator;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        SmartArray studentArr = new BaseArray(students);
        final int MIN_GPA = 4;
        final int CURRENT_YEAR = 2;
        studentArr = new DistinctDecorator(studentArr);
        studentArr = new FilterDecorator(
            studentArr, n -> 
            ((Student) n).getYear() == CURRENT_YEAR 
            && ((Student) n).getGPA() >= MIN_GPA);
        
        studentArr = new SortDecorator(
            studentArr, (n, m) -> 
            ((Student) n).getSurname().compareTo(
                ((Student) m).getSurname()));
        
        studentArr = new MapDecorator(
            studentArr, n ->
            String.format("%s %s", ((Student) n).getSurname(),
                            ((Student) n).getName()));
        
        Object[] result = studentArr.toArray();
        String[] finRes = Arrays.copyOf(result, result.length, String[].class);
        for (String string : finRes) {
            System.out.printf("name: %s\n", string);
        }
        return finRes;
        
        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
    }
}
