package chapter4;

import java.util.ArrayList;

public class Graph
{
    ArrayList <Node>data;

    public Graph(int[][] data, String[] nama,String name)
    {
        this.data = new ArrayList<Node>();
        this.readData_toNode(data,nama);
        this.distances(name);
//        System.out.println(this.search(name));
    }

    private void readData_toNode(int[][] data, String[] nama)
    {
        int nData = data.length;
        for (int i = 0; i<nData; i++)
        {
            this.data.add(new Node(data[i][0],data[i][1],nama[i]));
        }
    }

    public void viewData()
    {
        for (int i = 0;i < this.data.size();i++)
        {
            this.data.get(i).cetak();
        }
    }

    private double distance(Node a, Node b)
    {
        double dist = Math.sqrt(Math.pow((a.x-b.x),2)+Math.pow((a.y-b.y),2));
        return dist;
    }

    private void distances(String nama)
    {
        double []dist = new double [this.data.size()];
        for (int i = 0;i<this.data.size();i++)
        {
            dist[i] = this.distance(this.data.get(i),this.data.get(this.search(nama)));
            System.out.println("distance ke -"+i+" = "+dist[i]);
        }
    }

    private int search(String name)
    {
        int index = 0;
        for (int i = 0;i<this.data.size();i++)
        {
            if (this.data.get(i).name.equals(name))
            {
                index = i;
            }
        }
        return index;
    }
}
