package ds.test;

import java.io.StringReader;
import java.util.Scanner;

import ds.sort.Sorter;


public class Main {
  private static final int ERROR = -1;
  private static final int ADD = 0;
  private static final int REMOVE = 1;
  private static final int SORT = 2;
  private static final int TOP = 3;
  private static final int PRINT = 4;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = 200000;
    Sorter sorter = new Sorter(size);

    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      Scanner i_scanner = new Scanner(new StringReader(line));
      String cmd = i_scanner.next();
      int value = 0;
      int k = 0;
      String type = null;

      switch (getCommandNum(cmd)) {
        case ADD:
          value = i_scanner.nextInt();
          sorter.add(value);
          break;
        case REMOVE:
          value = i_scanner.nextInt();
          sorter.remove(value);
          break;
        case SORT:
          type = i_scanner.next();
          sorter.sort(type);
          break;
        case TOP:
          k = i_scanner.nextInt();
          type = i_scanner.next();
          sorter.top(k, type);
          break;
        case PRINT:
          sorter.print();
          break;
      }
      i_scanner.close();
    }
    scanner.close();
  }

  private static int getCommandNum(String cmd) {
    if (cmd.equals("add"))
      return ADD;
    if (cmd.equals("remove"))
      return REMOVE;
    else if (cmd.equals("sort"))
      return SORT;
    else if (cmd.equals("top"))
      return TOP;
    else if (cmd.equals("print"))
      return PRINT;
    else
      return ERROR;
  }

}
