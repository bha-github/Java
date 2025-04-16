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

        // Create the count map
        Map<String, Long> cityCountMap = cities.stream()
                .collect(Collectors.groupingBy(city -> city, Collectors.counting()));

        //Sort by count in descending order (sort by value)
        Map<String, Long> sortedCityCountMap = cityCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        // Print result
        System.out.println(sortedCityCountMap);

        //Sort by count in descending order (sort by key)
        Map<String, Long> sortedkeyCityCountMap = cityCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        // Print result
        System.out.println(sortedkeyCityCountMap);

        // Joining elements into a single String
        String joinedCities = cities.stream().collect(Collectors.joining(", "));

        System.out.println(joinedCities);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Summing all integers in the list
        int sum = numbers.stream().collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Sum: " + sum);

        int sum1 = numbers.stream().reduce(0, Integer::sum);

        System.out.println("Sum1: " + sum1);

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
