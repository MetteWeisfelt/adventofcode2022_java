package days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DaySeven {
    String name;
    int size = 0;
    ArrayList<DaySeven> children;
    DaySeven parent;
    static int totalSum = 0;
    static ArrayList<Integer> sizes = new ArrayList<Integer>();

    public DaySeven(String name, int size) {
        this.name = name;
        this.size = size;
        this.children = new ArrayList<DaySeven>();
    }

    public void setParent(DaySeven parent){
        this.parent = parent;
    }

    public void addChild(DaySeven child){
        this.children.add(child);
        child.setParent(this);
    }

    public static DaySeven findNode(DaySeven n, String name){
        for(DaySeven child : n.children){
            if(child.name.equals(name)){
                return child;
            }
        }
        System.out.println("heh");
        return null;
    }

    public static void traverse(DaySeven child){
        if(child == null){
            return;
        }

        for(DaySeven childLower : child.children){
            traverse(childLower);
        }

        if (child.parent != null){
            child.parent.size += child.size;

            if(child.size < 100000){
                totalSum += child.size;
            }
        }
    }

    // need to free 24.825.975 => so (5.174.025)
    public static void traverse2(DaySeven child){
        if(child == null){
            return;
        }

        for(DaySeven childLower : child.children){
            traverse2(childLower);
        }

        if (child.parent != null){
            child.parent.size += child.size;
            if(child.parent.size > 5174025){
                sizes.add(child.parent.size);
            }
        }
    }

    public static void buildTree(){

    }

    public static void runChallenge1() {
        System.out.println(">>> day 7 challenge 1 is starting now...");
        String line;
        DaySeven currentDaySeven = null;
        DaySeven root = null;

        try {
            File file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayseven.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null){
                if(line.charAt(0) == '$') {
                    String[] cdSplit = line.substring(2).split("\\s+");

                    // check if name or moving up on tree
                    if(cdSplit[0].equals("cd")){
                        if(!cdSplit[1].equals("..")) {
                            if(currentDaySeven == null){
                                root = new DaySeven("/", 0);
                                currentDaySeven = root;
                            } else {
                                currentDaySeven = findNode(currentDaySeven, cdSplit[1]);
                            }
                        } else {
                            // moving up directory
                            currentDaySeven = currentDaySeven.parent;
                        }
                    }
                } else {
                    String[] fileSplit = line.split("\\s+");
                    if(fileSplit[0].equals("dir")){
                        currentDaySeven.addChild(new DaySeven(fileSplit[1], 0));
                    } else {
                        currentDaySeven.size += Integer.parseInt(fileSplit[0]);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // postorder tree traversal
        traverse(root);
        System.out.println(">>> answer day 7 challenge 1: " + totalSum);
        System.out.println(">>> day 7 challenge 2 is starting now...");
        totalSum = 0;

        traverse2(root);
        Collections.sort(sizes);
        System.out.println(">>> answer day 7 challenge 2: " + sizes.get(0));
    }

    public static void runChallenge2() {

    }
}
