package projects;

import java.util.Scanner;
import static java.lang.System.out;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        System.out.println("Number of digits:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        number_of_elements(n, arr);
        number_of_different_numbers(n, arr);
        number_of_even_numbers(n, arr);
        number_of_odd_numbers(n, arr);
        frequency_of_repetition(n, arr);
        maximum_occurrence(n, arr);
        maximum_number(n, arr);
        second_smallest_number(n, arr);
        average_of_all_numbers(n, arr);
        standart_deviation(n, arr);
        median(n, arr);
        sum_of_all_numbers(n, arr);
        palindrom_numbers(n, arr);
        largest_palindrom_numbers_after(n, arr);
        reverse(n, arr);
    }

    //number of elements
    public static void number_of_elements(int n, int[] arr) {
        int ctr = 0;
        for (int i = 0 ; i < n ; i++) {
            ctr++;
        }
        out.println("Number of elements: " + ctr);
    }

    //number of different numbers
    public static void number_of_different_numbers(int n, int[] arr) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for(int i = 0; i < n; i++) {
            uniqueNumbers.add(arr[i]);
        }
        out.println("Number of different numbers: "+uniqueNumbers.size());
    }

    //number_of_even_numbers
    public static void number_of_even_numbers(int n, int[] arr) {
        int evenNumbers = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] % 2 == 0) {
                evenNumbers++;
            }
        }
        out.println("Number of even numbers: "+evenNumbers);
    }

    //number_of_odd_numbers
    public static void number_of_odd_numbers(int n, int[] arr) {
        int oddNumbers = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] % 2 != 0) {
                oddNumbers++;
            }
        }
        out.println("Number of odd numbers: "+oddNumbers);
    }
    //frequency of repetition for each number (in percentage)
    public static void frequency_of_repetition(int n, int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0)+1);
        }
        out.println("Frequency of repetition for each number (in percentage): ");
        for(int i: frequencyMap.keySet()) {
            double percentage = ((double)frequencyMap.get(i) / n) * 100;
            out.printf("%d: %.2f%%\n", i, percentage);
        }

    }

    //the number with the maximum occurrence
    public static void maximum_occurrence(int n, int[] arr) {
        Map<Integer, Integer> elementCount = new HashMap<>();
        //Подсчет элементов
        for(int element: arr) {
            elementCount.put(element, elementCount.getOrDefault(element, 0) + 1);
        }
            //Переменные для хранения элемента с макимальным количеством вхождений
        int maxCount = 0;
        int maxElement = -1;
            //Нахождение элемента с макисмальным количеством вхождений
        for(Map.Entry<Integer, Integer> entry: elementCount.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxElement = entry.getKey();
            }
        }
        out.println("Element "+maxElement+" meets "+maxCount);
    }

    //maximum number
    public static void maximum_number(int n, int[] arr) {
        int maxNumber = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > maxNumber) {
                maxNumber = arr[i];
            }
        }
        out.println("Largest number: "+maxNumber);
    }
    //second small number
    public static void second_smallest_number(int n, int[] arr) {
        int [] copy = arr.clone();
        Arrays.sort(copy);
        out.println("Second smallest number: "+copy[1]);
    }

    //average of all numbers
    public static void average_of_all_numbers(int n, int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double result = (double) sum / n;
        out.print("Average of all numbers: ");
        out.printf("%2f", result);
        out.println();
    }

    //standard deviation
    public static void standart_deviation(int n, int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double resultFirst = (double) sum / n;
        //Вычисление суммы квадратов отклонений
        double squaredSum = 0.0;
        for(double num: arr) {
            squaredSum += Math.pow(num - resultFirst, 2);
        }
        //Вычисление среднеквадратичного отклонения
        double resultSecond = squaredSum / n;
        double standardDeviation = Math.sqrt(resultSecond);
        out.println("Standard Deviation: "+standardDeviation);
    }

    //median
    public static void median(int n, int[] arr) {
        int [] copy = arr.clone();
        Arrays.sort(copy);
        double median;
        if(n % 2 == 0) {
            median = ((double) copy[n / 2 - 1] + copy[n / 2]) / 2;
        } else {
            median = copy[n/2];
        }
        out.println("Mdeian: "+median);
    }

    //sum of all numbers
    public static void sum_of_all_numbers(int n, int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        out.println("Sum of all numbers: "+sum);
    }

    //count the number of palindromic number numbers
    public static void palindrom_numbers(int n, int[] arr) {
        List<Integer> palindromList = new ArrayList<>();
        for(int num: arr) {
            if(num <= 9) {
                palindromList.add(num);
            } else {
                int firstPart = num / 10;
                int secondPart = num % 10;
                if(firstPart == secondPart) {
                    palindromList.add(num);
                }
            }
        }
        out.println("Palindromic number numbers: "+palindromList.size());
    }

    //largest palindromic number, that is small then the greatest number in the list.
    public static void largest_palindrom_numbers_after(int n, int[] arr) {
        List<Integer> List = new ArrayList<>();
        for(int num: arr) {
            if(num <= 9) {
                List.add(num);
            } else {
                int firstPart = num / 10;
                int secondPart = num % 10;
                if(firstPart == secondPart) {
                    List.add(num);
                }
            }
        }
        Collections.sort(List);
        int secondLast  = List.get(List.size() - 2);
        out.println("Second largest palindrom list element: "+secondLast);
    }
    //the program must end by printing out the received numbers in the reversed order delimited by a comma.
    public static void reverse(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int num: arr) {
            list.add(num);
        }
        Collections.reverse(list);
        String result = list.stream().map(String::valueOf).collect(Collectors.joining(", "));
        out.println(result);
    }
}
