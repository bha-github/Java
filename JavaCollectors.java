import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaCollectors {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Mumbai", "Delhi", "Bangalore", "Chennai","Mumbai","Chennai");

        // Collecting the stream into a List
        List<String> cityList = cities.stream().collect(Collectors.toList());

        System.out.println(cityList);

        // Collecting the stream into a Set
        Set<String> citySet = cities.stream().collect(Collectors.toSet());

        System.out.println(citySet);

        // Collecting the stream into a Map (city name -> city name length)
        Map<String, Integer> cityMap = citySet.stream()
                                             .collect(Collectors.toMap(city -> city, city -> city.length()));

        System.out.println(cityMap);

        // Joining elements into a single String
        String joinedCities = cities.stream().collect(Collectors.joining(", "));

        System.out.println(joinedCities);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Summing all integers in the list
        int sum = numbers.stream().collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Sum: " + sum);

        // Calculating the average of all integers in the list
        double average = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));

        System.out.println("Average: " + average);

        List<String> names = Arrays.asList("Amit", "Deepa", "Rahul", "Akhil");

        // Grouping names by the first letter
        Map<Character, List<String>> groupedByLetter = names.stream()
                                                            .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println(groupedByLetter);

        // Partitioning numbers into even and odd
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                                                         .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println(partitioned);
    }
}