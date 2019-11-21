package br.edu.logatti;

import java.util.Arrays;
import java.util.Scanner;

public class Trabalho {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean isMenuOpen = true;
		int[] vetor = null;
		int n = 0;

		while (isMenuOpen) {
			printMenu();
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Informe um tamanho: ");
				vetor = new int[sc.nextInt()];
				generateVetor(vetor);
				break;
			case 2:
				printVetor(vetor);
				break;
			case 3:
				bubbleSort(vetor);
				break;
			case 4:
				selectionSort(vetor);
				break;
			case 5:
				insertionSort(vetor);
				break;
			case 6:
				mergeSort(vetor);
				break;
			case 7:
				quickSort(vetor, 0, vetor.length - 1);
				break;
			case 8:
				System.out.println("Informe um número inteiro para buscar no vetor");
				n = sc.nextInt();
				int index1 = linearSearch(vetor, n);
				printNumberSearch(index1, n);
				break;
			case 9:
				System.out.println("Informe um número inteiro para buscar no vetor");
				n = sc.nextInt();
				int index2 = sortedLinearSearch(vetor, n);
				printNumberSearch(index2, n);
				break;
			case 10:
				System.out.println("Informe um número inteiro para buscar no vetor");
				n = sc.nextInt();
				int index3 = binarySearch(vetor, 0, vetor.length - 1, n);
				printNumberSearch(index3, n);
				break;
			case 0:
				isMenuOpen = false;
				break;
			default:
				printMenu();
				break;
			}
		}

	}

	public static void printMenu() {
		System.out.println("\n\nEscolha uma opção: ");
		System.out.println("1 - (Informar tamanho do vetor) ");
		System.out.println("2 - (Visualizar Vetor) ");
		System.out.println("3 - (BubbleSort) ");
		System.out.println("4 - (SelectionSort) ");
		System.out.println("5 - (InsertionSort) ");
		System.out.println("6 - (MergeSort) ");
		System.out.println("7 - (QuickSort) ");
		System.out.println("8 - (LinearSearch) ");
		System.out.println("9 - (Busca Sequencial Ordenada) ");
		System.out.println("10 - (Busca Binária) ");
		System.out.println("0 - (Sair) ");
	}

	public static void printNumberSearch(int index, int n) {
		if (index == -1) {
			System.out.println(String.format("o número %s não se encontra no vetor. ", n));
		} else {
			System.out.println(String.format("o número %s está na posição %s", n, (index + 1)));
		}
	}

	public static void generateVetor(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			int n = generateRandomNumber(1, vetor.length * 10);

			do {
				n = generateRandomNumber(1, vetor.length * 10);
			} while (contains(vetor, n));

			vetor[i] = n;
		}
	}

	public static int generateRandomNumber(final int min, final int max) {
		return (int) (Math.random() * max + min);
	}

	public static boolean contains(int[] vetor, int n) {
		return linearSearch(vetor, n) == -1 ? false : true;
	}

	public static void printVetor(int[] vetor) {
		System.out.println(Arrays.toString(vetor));
	}

	public static void bubbleSort(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length - 1; j++) {
				if (vetor[j] > vetor[j + 1]) {
					int aux = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
				}
			}
		}
	}

	public static void selectionSort(int vetor[]) {
		int n = vetor.length;

		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (vetor[j] < vetor[min_idx]) {
					min_idx = j;
				}
			}

			int temp = vetor[min_idx];
			vetor[min_idx] = vetor[i];
			vetor[i] = temp;
		}
	}

	public static void insertionSort(int[] vetor) {
		int n = vetor.length;
		for (int i = 1; i < n; ++i) {
			int key = vetor[i];
			int j = i - 1;

			while (j >= 0 && vetor[j] > key) {
				vetor[j + 1] = vetor[j];
				j = j - 1;
			}
			vetor[j + 1] = key;
		}
	}

	public static void mergeSort(int[] vetor) {
		int n = vetor.length;
		if (n < 2)
			return;
		int mid = n / 2;
		int left[] = new int[mid];
		int right[] = new int[n - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = vetor[i];
		}
		for (int i = mid; i < n; i++) {
			right[i - mid] = vetor[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(vetor, left, right);
	}

	public static void merge(int vetor[], int left[], int right[]) {
		int nLeft = left.length;
		int nRight = right.length;
		int i = 0, j = 0, k = 0;
		while (i < nLeft && j < nRight) {
			if (left[i] <= right[j]) {
				vetor[k] = left[i];
				i++;
			} else {
				vetor[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < nLeft) {
			vetor[k] = left[i];
			i++;
			k++;
		}
		while (j < nRight) {
			vetor[k] = right[j];
			j++;
			k++;
		}
	}

	public static void quickSort(int[] vetor, int low, int high) {
		if (low < high) {
			int pi = partition(vetor, low, high);

			quickSort(vetor, low, pi - 1);
			quickSort(vetor, pi + 1, high);
		}
	}

	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	public static int linearSearch(int[] vetor, int n) {
		for (int i = 0; i < vetor.length; i++) {
			int aux = vetor[i];
			if (aux > n) {
				return -1;
			}

			if (aux == n) {
				return i;
			}

		}

		return -1;
	}

	public static int sortedLinearSearch(int[] vetor, int n) {
		quickSort(vetor, 0, vetor.length - 1);

		for (int i = 0; i < vetor.length; i++) {
			int aux = vetor[i];
			if (aux > n) {
				return -1;
			}

			if (aux == n) {
				return i;
			}

		}

		return -1;
	}

	public static int binarySearch(int[] vetor, int l, int r, int n) {
		if (r >= l) {
			int mid = l + (r - l) / 2;

			if (vetor[mid] == n)
				return mid;

			if (vetor[mid] > n)
				return binarySearch(vetor, l, mid - 1, n);

			return binarySearch(vetor, mid + 1, r, n);
		}

		return -1;
	}

}
