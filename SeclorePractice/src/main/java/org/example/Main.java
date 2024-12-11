package org.example;

/// A Java program to find same contacts in a list of
// contacts
import java.util.ArrayList;

public class Main {

    // Structure for storing contact details.
    static class contact {
        String field1, field2, field3;
        contact(String s1, String s2, String s3)
        {
            field1 = s1;
            field2 = s2;
            field3 = s3;
        }
    };

    // A utility function to fill entries in adjacency
// matrix representation of graph
    static void
    buildGraph(contact arr[], int n,
               ArrayList<ArrayList<Integer> > mat)
    {
        // Initialize the adjacency matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat.get(i).add(0);

        // Traverse through all contacts
        for (int i = 0; i < n; i++) {

            // Add mat from i to j and vice versa, if
            // possible. Since length of each contact field
            // is at max some constant. (say 30) so body
            // execution of this for loop takes constant
            // time.
            for (int j = i + 1; j < n; j++)
                if (arr[i].field1 == arr[j].field1
                        || arr[i].field1 == arr[j].field2
                        || arr[i].field1 == arr[j].field3
                        || arr[i].field2 == arr[j].field1
                        || arr[i].field2 == arr[j].field2
                        || arr[i].field2 == arr[j].field3
                        || arr[i].field3 == arr[j].field1
                        || arr[i].field3 == arr[j].field2
                        || arr[i].field3 == arr[j].field3) {
                    mat.get(i).set(j, 1);
                    mat.get(j).set(i, 1);
                    break;
                }
        }
    }

    // A recursive function to perform DFS with vertex i as
// source
    static void DFSvisit(int i,
                         ArrayList<ArrayList<Integer> > mat,
                         boolean visited[],
                         ArrayList<Integer> sol, int n)
    {
        visited[i] = true;
        sol.add(i);

        for (int j = 0; j < n; j++)
            if (mat.get(i).get(j) != 0 && !visited[j])
                DFSvisit(j, mat, visited, sol, n);
    }

    // Finds similar contacts in an array of contacts
    static void findSameContacts(contact arr[], int n)
    {
        // vector for storing the solution
        ArrayList<Integer> sol = new ArrayList<>();

        // Declare 2D adjacency matrix for mats
        ArrayList<ArrayList<Integer> > mat
                = new ArrayList<>();

        for (int i = 0; i < n; i++)
            mat.add(new ArrayList<>());

        // visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];

        // Fill adjacency matrix
        buildGraph(arr, n, mat);

        // Since, we made a graph with contacts as nodes
        // with fields as links. two nodes are linked if
        // they represent the same person. so, total number
        // of connected components and nodes in each
        // component will be our answer.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFSvisit(i, mat, visited, sol, n);

                // Add delimiter to separate nodes of one
                // component from other.
                sol.add(-1);
            }
        }

        // Print the solution
        for (int i = 0; i < sol.size(); i++)
            if (sol.get(i) == -1)
                System.out.println();
            else
                System.out.print(sol.get(i) + " ");
    }

    // Drive Code
    public static void main(String[] args)
    {
        contact arr[] = {
                new contact("Gaurav", "gaurav@gmail.com",
                        "gaurav@gfgQA.com"),
                new contact("Lucky", "lucky@gmail.com",
                        "+1234567"),
                new contact("gaurav123", "+5412312",
                        "gaurav123@skype.com"),
                new contact("gaurav1993", "+5412312",
                        "gaurav@gfgQA.com"),
                new contact("raja", "+2231210", "raja@gfg.com"),
                new contact("bahubali", "+878312", "raja")
        };

        int n = arr.length;
        findSameContacts(arr, n);
    }
}

// This code is contributed by Karandeep1234
