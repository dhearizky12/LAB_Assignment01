package LAB_Assignment01; // package untuk mengelompokkan kelas-kelas yang terkait

//=========================================================
// Nama : Dhea Fiky Fatchatur Rizky
// NIM  : 2802621393
// Tugas: Perbandingan Array vs ArrayList (Week 5)
//=========================================================

import java.util.*; // import library terkait untuk ArrayList, Arrays, Collections

class ArrayOperations 
{
    //method traverse untuk mengakses elemen setiap array dan menampilkan ke layar
    public void traverse(int[] arr) 
    {
        System.out.println("Array Traversal: " + Arrays.toString(arr));
    }

    //method linearSearch untuk mencari nilai dalam array secara linear
    public int linearSearch(int[] arr, int value) 
    {
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    //method binarySearch untuk mencari nilai dalam array secara biner
    public int binarySearch(int[] arr, int value) 
    {
        Arrays.sort(arr);
        return Arrays.binarySearch(arr, value);
    }

    //method insert untuk menambahkan elemen baru pada array di indeks tertentu
    public int[] insert(int[] arr, int value, int index) 
    {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        newArr[index] = value;
        System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
        return newArr;
    }

    //method delete untuk menghapus elemen pada array di indeks tertentu
    public int[] delete(int[] arr, int index) 
    {
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);
        return newArr;
    }
}

class ArrayListOperations 
{
    public void traverse(ArrayList<Integer> list) 
    {
        System.out.println("ArrayList Traversal: " + list);
    }

    //method search untuk mencari nilai dalam ArrayList
    //menggunakan indexOf yang mengembalikan indeks dari nilai yang dicari
    public int search(ArrayList<Integer> list, int value) 
    {
        return list.indexOf(value);
    }

    //method insert untuk menambahkan elemen baru pada ArrayList di indeks tertentu
    // menggunakan add(index, value) yang menambahkan nilai pada indeks yang ditentukan
    public void insert(ArrayList<Integer> list, int value, int index) 
    {
        list.add(index, value);
    }

    //method delete untuk menghapus elemen pada ArrayList di indeks tertentu
    //menggunakan remove(index) yang menghapus elemen pada indeks yang ditentukan
    public void delete(ArrayList<Integer> list, int index) 
    {
        list.remove(index);
    }

    //method sort untuk mengurutkan ArrayList
    public void sort(ArrayList<Integer> list) 
    {
        Collections.sort(list);
    }
}

public class Comparison 
{
    public static void main(String[] args) 
    {
        opening();
        showHeader();

        ArrayOperations arrayOps = new ArrayOperations(); //membuat objek dari kelas ArrayOperations
        ArrayListOperations listOps = new ArrayListOperations(); //membuat objek dari kelas ArrayListOperations

        int[] array = {10, 20, 30, 40, 50}; // membuat array dengan elemen yang sama
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)); // membuat ArrayList dengan elemen yang sama

        System.out.println("|-----------------------------------------------------|");
        System.out.println("| Traversal                                           |");
        System.out.println("|-----------------------------------------------------|");
        showExecutionTime(() -> arrayOps.traverse(array), "Traversal Array");
        showExecutionTime(() -> listOps.traverse(arrayList), "Traversal ArrayList");

        System.out.println("|-----------------------------------------------------|");
        System.out.println("| Search (cari nilai 30)                              |");
        System.out.println("|-----------------------------------------------------|");
        showExecutionTime(() -> {
            int indexArr = arrayOps.linearSearch(array, 30);
            System.out.println("Pencarian dengan linear search 30 dalam Array: Ditemukan di indeks " + indexArr);
        }, "Search di Array");

        showExecutionTime(() -> {
            int indexArr = arrayOps.binarySearch(array, 30);
            System.out.println("Pencarian dengan binary search 30 dalam Array: Ditemukan di indeks " + indexArr);
        }, "Search di Array");

        showExecutionTime(() -> {
            int indexList = listOps.search(arrayList, 30);
            System.out.println("Pencarian 30 dalam ArrayList: Ditemukan di indeks " + indexList);
        }, "Search di ArrayList");

        System.out.println("|-----------------------------------------------------|");
        System.out.println("| Insert nilai 25 di indeks ke-2                      |");
        System.out.println("|-----------------------------------------------------|");
        // Gunakan array 2 dimensi untuk menyimpan hasil insert
        final int[][] arrayInserted = new int[1][];
        showExecutionTime(() -> {
            arrayInserted[0] = arrayOps.insert(array, 25, 2);
            arrayOps.traverse(arrayInserted[0]);
        }, "Insert ke Array");


        showExecutionTime(() -> {
            listOps.insert(arrayList, 25, 2);
            listOps.traverse(arrayList);
        }, "Insert ke ArrayList");

        System.out.println("|-----------------------------------------------------|");
        System.out.println("| Delete indeks ke-2                                  |");
        System.out.println("|-----------------------------------------------------|");
        // // Gunakan array 2 dimensi untuk menyimpan hasil delete
        final int[][] arrayDeleted = new int[1][];
        showExecutionTime(() -> {
            arrayDeleted[0] = arrayOps.delete(arrayInserted[0], 2);
            arrayOps.traverse(arrayDeleted[0]);
        }, "Delete dari Array");

        showExecutionTime(() -> {
            listOps.delete(arrayList, 2);
            listOps.traverse(arrayList);
        }, "Delete dari ArrayList");

        System.out.println("|-----------------------------------------------------|");
        System.out.println("| Sorting ArrayList                                   |");
        System.out.println("|-----------------------------------------------------|");
        showExecutionTime(() -> {
            listOps.sort(arrayList);
            listOps.traverse(arrayList);
        }, "Sorting ArrayList");

        System.out.println("|=====================================================|");
        System.out.println("|               TUGAS SELESAI                         |");
        System.out.println("|=====================================================|");
    }

    //method untuk mengukur waktu eksekusi dari task yang diberikan
    // menerima Runnable task dan label untuk menampilkan hasil
    //runnable adalah antarmuka fungsional yang memungkinkan kita untuk menjalankan kode dalam bentuk lambda
    public static void showExecutionTime(Runnable task, String label) 
    {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        System.out.printf("Execution Time (%s): %.5f ms%n", label, (end - start) / 1_000_000.0);
    }

    public static void opening() 
    {
        System.out.print("Loading");
        try 
        {
            for (int i = 0; i < 5; i++) 
            {
                Thread.sleep(300);
                System.out.print(".");
            }
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n");
    }

    public static void showHeader() 
    {
        System.out.println("|=====================================================|");
        System.out.println("| Nama    : Dhea Fiky Fatchatur Rizky                 |");
        System.out.println("| NIM     : 2802621393                                |");
        System.out.println("| Jurusan : Computer Science                          |");
        System.out.println("|=====================================================|");
    }
}
