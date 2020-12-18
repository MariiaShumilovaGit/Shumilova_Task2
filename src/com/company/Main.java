package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите 5 чисел: ");
        Scanner scanner = new Scanner(System.in);

        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        int number4 = scanner.nextInt();
        int number5 = scanner.nextInt();

        int[] array = new int[]{
                number1, number2, number3, number4, number5
        };

        //задание 1
        int length = String.valueOf(array[0]).length();
        String number = String.valueOf(array[0]);
        for (int i = 1; i < array.length; i++) {
            int tempLength = String.valueOf(array[i]).length();
            if (length >= tempLength) {
                length = tempLength;
                number = String.valueOf(array[i]);
            }
        }
        System.out.println("Самое короткое число: " + number + ". Его длина: " + length);

        length = String.valueOf(array[0]).length();
        number = String.valueOf(array[0]);
        for (int i = 1; i < array.length; i++) {
            int tempLength = String.valueOf(array[i]).length();
            if (length <= tempLength) {
                length = tempLength;
                number = String.valueOf(array[i]);
            }
        }
        System.out.println("Самое длинное число: " + number + ". Его длина: " + length);

        //задание 2
        int[] task2Array = array.clone();
        for (int i = task2Array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (String.valueOf(task2Array[j]).length() > String.valueOf(task2Array[j + 1]).length()) {
                    int temp = task2Array[j];
                    task2Array[j] = task2Array[j + 1];
                    task2Array[j + 1] = temp;
                }
            }
        }
        System.out.println("Числа в порядке возрастания их длины: " + Arrays.toString(task2Array));

        //задание 3

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + String.valueOf(array[i]).length();
        }
        int avg = sum / array.length;
        System.out.println("Числа, длина которых меньше средней " + "(" + avg + "):");
        for (int i = 0; i < array.length; i++) {
            if (String.valueOf(array[i]).length() < avg) {
                System.out.println("Число: " + array[i] + ". Длина: " + String.valueOf(array[i]).length());
            }
        }

        //задание 4

        int differentNumbersCount = 0;
        String numberToShow = "No numbers";
        for (int i = 0; i < array.length; i++)
        {
            if (String.valueOf(array[i]).length()==1){
                numberToShow = String.valueOf(array[i]);
                break;
            }

            int sameNumbersCount = 0;
            byte[] bytesArray = String.valueOf(array[i]).getBytes();
            Arrays.sort(bytesArray);
            for (int j = 0; j < bytesArray.length - 1; j++)
            {
                if (bytesArray[j] == bytesArray[j + 1])
                {
                    sameNumbersCount = sameNumbersCount + 1;
                    if (j == bytesArray.length-2)
                    {
                        sameNumbersCount = sameNumbersCount + 1;
                    }
                }

                else if (bytesArray[j] != bytesArray[j + 1] && sameNumbersCount != 0)
                {
                    sameNumbersCount = sameNumbersCount + 1;
                }
            }

            if (sameNumbersCount != 0)
            {
                int tempDifferentNumbersCount = bytesArray.length - sameNumbersCount;
                if (tempDifferentNumbersCount == 0)
                {
                    numberToShow = String.valueOf(array[i]);
                    break;
                }

                if (i == 1 || tempDifferentNumbersCount < differentNumbersCount)
                {
                    differentNumbersCount = tempDifferentNumbersCount;
                    numberToShow = String.valueOf(array[i]);
                }
            }
        }
        System.out.println("Число, в котором число различных цифр минимально: "+numberToShow);

        //задание 6
        for (int i = 0; i < array.length; i++) {
            if (String.valueOf(array[i]).length() != 1) {
                byte[] bytesArray = String.valueOf(array[i]).getBytes();
                byte[] tempArray = bytesArray.clone();
                Arrays.sort(bytesArray);
                if (Arrays.equals(tempArray, bytesArray)) {
                    System.out.println("Число, цифры в котором идут в порядке возрастания: " + array[i]);
                    break;
                }
            }
        }

        //задание 7

        numberToShow = "No numbers";
        outerloop:
        for (int i = 0; i < array.length; i++) {
            if (String.valueOf(array[i]).length() != 1) {
                //int sameNumbersCount = 0;
                byte[] bytesArray = String.valueOf(array[i]).getBytes();
                Arrays.sort(bytesArray);
                innerloop:
                for (int j = 0; j < bytesArray.length - 1; j++) {
                    if (bytesArray[j] == bytesArray[j + 1]) {
                        break innerloop;
                    }
                    if (j == bytesArray.length - 2) {
                        numberToShow = String.valueOf(array[i]);
                        break outerloop;
                    }
                }
            }
        }
        System.out.println("Число, состоящее только из различных цифр: " + numberToShow);

//задание 8
        Scanner input = new Scanner(System.in);
        System.out.println("Задайте размер матрицы: ");
        int size = input.nextInt();
        int matrix[][] = new int[size][size];
        System.out.println("Введите элементы матрицы: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        //задание 9
        System.out.println("Введите размер матрицы: ");
        size = input.nextInt();
        matrix = new int[size][size];
        fillMatrix(matrix, size);
        System.out.println("Полученная матрица: ");
        printMatrix(matrix, size);
        sumElemMatrixBetweenNegativeElem();
        matrixInIncreaseOrder(matrix, size);
        matrixShifted(matrix, size);
        countMaxAmoutIncElem(matrix, size);
        rotateMatrix90(matrix, size);
        System.out.println("Матрица,повернутая на 90: ");
        printMatrix(matrix, size);
        rotateMatrix90(matrix, size);
        System.out.println("Матрица,повернутая на 180: ");
        printMatrix(matrix, size);
        rotateMatrix90(matrix, size);
        System.out.println("Матрица,повернутая на 270: ");
        printMatrix(matrix, size);
        System.out.println("Матрица с нулевыми элементами вконце строки: ");
        matrixWithZeroElemInTheEnd(matrix, size);
        printMatrix(matrix, size);
        matrixWithMinesAvr(matrix, size);
        printMatrix(matrix, size);
        matrixWithoutZeroRowAndCol();
    }

    private static int[][] fillMatrix(int[][] matrix, int size) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 2 * size - size);
            }
        }
        return matrix;
    }

    private static int[][] printMatrix(int[][] matrix, int size) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        return matrix;
    }

    // задание 9.1
    private static void matrixInIncreaseOrder(int[][] matrix, int size) {
        int[] vector = new int[size * size];
        int[][] matrixSorted = new int[size][size];
        int n = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                vector[i * size + j] = matrix[i][j];

        Arrays.sort(vector);
        for (int i1 = 0; i1 < matrixSorted.length; i1++) {
            for (int j1 = 0; j1 < matrixSorted[i1].length; j1++) {
                matrixSorted[i1][j1] = vector[n];
                n++;
            }
        }
        System.out.println("Матрица в порядке возрастания: ");
        for (int i = 0; i < matrixSorted.length; i++) {
            for (int j = 0; j < matrixSorted[i].length; j++) {
                System.out.print(matrixSorted[i][j] + "\t");
            }
            System.out.println();
        }

    }

    //задание 9.2
    private static void matrixShifted(int[][] matrix, int size) {
        int[][] matrixShifted = new int[size][size];
        int k = 1;
        int knew = size - k % size;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixShifted[i][(j + k) % size] = matrix[i][j];
            }
        }

        System.out.println("Матрица повернутая направо: ");
        for (int i = 0; i < matrixShifted.length; i++) {
            for (int j = 0; j < matrixShifted[i].length; j++) {
                System.out.print(matrixShifted[i][j] + "\t");
            }
            System.out.println();
        }

    }

    // задание 9.3
    private static void countMaxAmoutIncElem(int[][] matrix, int size) {
        int count = 0;
        int deccount = 0;
        int max = 0;
        int min = 0;
        int index = 0;
        int decindex = 0;
        int[] vector = new int[size * size];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                vector[i * size + j] = matrix[i][j];

        for (int k = 0; k < vector.length - 1; k++) {
            if (vector[k] < vector[k + 1]) {
                count++;
                if (count > max) {
                    max = count;
                    index = k + 1;
                }
            } else {
                count = 0;
            }
            if (vector[k] > vector[k + 1]) {
                deccount++;
                if (deccount > min) {
                    min = deccount;
                    decindex = k + 1;
                }
            } else {
                deccount = 0;
            }
        }

        System.out.println("Максимальная последовательность возрастающих элементов: ");
        int[] sequence = new int[max + 1];
        System.arraycopy(vector, (index - max), sequence, 0, (max + 1));
        System.out.println(Arrays.toString(sequence) + " " + (max + 1) + " " + "elements");
        System.out.println("Максимальная последовательность убывающих элементов: ");
        int[] decsequence = new int[min + 1];
        System.arraycopy(vector, (decindex - min), decsequence, 0, (min + 1));
        System.out.println(Arrays.toString(decsequence) + " " + (min + 1) + " " + "elements");

    }

    //  задание 9.4
    private static void sumElemMatrixBetweenNegativeElem() {
        int[][] matrix2 = new int[][]{
                {1, 0, -3, 4, -9, 0},
                {0, -2, -1, 0, 0, 0},
                {-8, 1, -3, 0, 0, 0},
                {9, 0, 0, -4, 0, -1},
                {-4, 2, 1, 0, -5, 0},
                {11, -3, 3, 4, 0, -1}};

        int indexStartj = 0;
        int indexEndj = 0;

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {

                if (matrix2[i][j] < 0) {
                    indexStartj = j;
                    System.out.println("1-е негативное число: " + matrix2[i][indexStartj]);
                    break;

                }
            }

            for (int j1 = indexStartj + 1; j1 < matrix2[i].length; j1++) {
                if (matrix2[i][j1] < 0) {
                    indexEndj = j1;
                    System.out.println("2-е негативное число: " + matrix2[i][indexEndj]);
                    break;

                }
            }

            int sum = 0;
            for (int l = indexStartj + 1; l < indexEndj; l++)
                sum += matrix2[i][l];
            {
                System.out.println("Сумма элементов: " + sum);
            }
        }
    }

    // задание 9.5
    private static int[][] rotateMatrix90(int[][] matrix, int size) {

        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - 1 - i; j++) {
                int x = matrix[i][j];
                matrix[i][j] = matrix[j][size - 1 - i];
                matrix[j][size - 1 - i] = matrix[size - 1 - i][size - 1 - j];
                matrix[size - 1 - i][size - 1 - j] = matrix[size - 1 - j][i];
                matrix[size - 1 - j][i] = x;
            }
        }
        return matrix;
    }

    // задание 9.6
    public static double matrixAvr(double[][] matrix) {
        double sum = 0;
        double avr = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[i][j];

            }
            avr = sum / matrix.length;
        }
        return avr;
    }

    public static int[][] matrixWithMinesAvr(int[][] matrix, int avr) {
        System.out.println("Среднее арифметическое матрицы: " + avr);
        System.out.println("Матрица с элементами средних знаечений: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] -= avr;
            }
        }
        return matrix;
    }

    //задание 9.7
    private static void matrixWithoutZeroRowAndCol() {
        int N = 6;
        boolean zero = false;
        int n = N, m = N;
        int[][] newmatrix = new int[][]{
                {1, 0, 3, 4, 8, 0},
                {0, 0, 0, 0, 0, 0},
                {8, 0, 3, 0, 0, 0},
                {9, 0, 0, 4, 0, 0},
                {4, 0, 0, 0, 5, 0},
                {11, 0, 0, 0, 0, 0}};

        for (int i = 0; i < n; i++) {
            zero = true;
            for (int j = 0; j < m; j++)
                if (newmatrix[i][j] != 0) {
                    zero = false;
                    break;
                }
            if (zero) {
                for (int k = i; k < (n - 1); k++)
                    for (int j = 0; j < m; j++)
                        newmatrix[k][j] = newmatrix[k + 1][j];
                --i;
                --n;
            }
        }

        for (int j = 0; j < m; j++) {
            zero = true;
            for (int i = 0; i < n; i++)
                if (newmatrix[i][j] != 0) {
                    zero = false;
                    break;
                }
            if (zero) {
                for (int k = j; k < (m - 1); k++)
                    for (int i = 0; i < m; i++)
                        newmatrix[i][k] = newmatrix[i][k + 1];
                --j;
                --m;
            }
        }
        System.out.println("Матрица без нулевой строки или колонки: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(newmatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //задание 9.8
    static void matrixWithZeroElemInTheEnd(int[][] matrix, int size) {

        for (int i = 0; i < matrix.length; i++) {
            int n = 0;
            int[] temp = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    temp[n++] = matrix[i][j];
                }
            }
            matrix[i] = Arrays.copyOf(temp, temp.length);
        }
    }
}





