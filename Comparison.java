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
        arrayOps.traverse(array);
        listOps.traverse(arrayList);

        System.out.println("|-----------------------------------------------------|");
        System.out.println("| Search (cari nilai 30)                              |");
        System.out.println("|-----------------------------------------------------|");
        long start = System.nanoTime();
        int indexArr = arrayOps.linearSearch(array, 30);
        long end = System.nanoTime();
        System.out.println("Pencarian 30 dalam Array: Ditemukan di indeks " + indexArr);
        System.out.println("Waktu eksekusi pencarian pada Array: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        int indexList = listOps.search(arrayList, 30);
        end = System.nanoTime();
        System.out.println("Pencarian 30 dalam ArrayList: Ditemukan di indeks " + indexList);
        System.out.println("Waktu eksekusi pencarian pada ArrayList: " + (end - start) / 1_000_000.0 + " ms");

        System.out.println("|-----------------------------------------------------|");
        System.out.println("| Insert nilai 25 di indeks ke-2                      |");
        System.out.println("|-----------------------------------------------------|");
        int[] arrayInserted = arrayOps.insert(array, 25, 2);
        arrayOps.traverse(arrayInserted);
        listOps.insert(arrayList, 25, 2);
        listOps.traverse(arrayList);

        System.out.println("|-----------------------------------------------------|");
        System.out.println("| Delete indeks ke-2                                  |");
        System.out.println("|-----------------------------------------------------|");
        int[] arrayDeleted = arrayOps.delete(arrayInserted, 2);
        arrayOps.traverse(arrayDeleted);
        listOps.delete(arrayList, 2);
        listOps.traverse(arrayList);

        System.out.println("|-----------------------------------------------------|");
        System.out.println("| Sorting ArrayList                                   |");
        System.out.println("|-----------------------------------------------------|");
        listOps.sort(arrayList);
        listOps.traverse(arrayList);

        System.out.println("|=====================================================|");
        System.out.println("|               TUGAS SELESAI                         |");
        System.out.println("|=====================================================|");
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
        System.out.println("| Nama : Dhea Fiky Fatchatur Rizky                    |");
        System.out.println("| NIM  : 2802621393                                   |");
        System.out.println("|=====================================================|");
    }
}
