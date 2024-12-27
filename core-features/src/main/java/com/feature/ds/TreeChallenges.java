package com.feature.ds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeChallenges {

    public static void main() {
        Tree tree = new Tree(1, new Tree(2,   new Tree(4), new Tree(5) ), new Tree(3, new Tree(6 ), new Tree(7)));
        inOrderTraversal(tree, 0);
        System.out.println("*********************************");
        System.out.println(findHeight(tree));
        System.out.println("*********************************");
        traversalUsingStack(tree);
        System.out.println("*********************************");
        levelWiseTraversal(tree);
        System.out.println("*********************************");
    }

    private static int findHeight(Tree tree) {
        if (tree == null) return 0;
        int leftHeight = findHeight(tree.left);
        int rightHeight = findHeight(tree.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static void inOrderTraversal(Tree tree, int level) {
        if (tree == null) return;
        inOrderTraversal(tree.left, level + 1);
        System.out.println(" ".repeat(level*5) + tree.data);
        inOrderTraversal(tree.right, level + 1);
    }

    private static void traversalUsingStack(Tree tree) {
        if (tree == null) return;
        Stack<Tree> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            Tree current = stack.pop();
            System.out.println(current.data);
            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }

    }

    private static void levelWiseTraversal(Tree tree) {
        if (tree == null) return;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        queue.add(null);

        int level = 0;

        while (queue.size() > 1) {
            Tree current = queue.poll();
            if ( current == null) {
                level++;
                queue.add(null);
            } else {
                System.out.println(" ".repeat(level*5) + current.data);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

        }

    }

    public boolean isSymmetric(Tree root) {
        return isSame(root.left, root.right);
    }

    public boolean isSame(Tree left, Tree right) {

        if(left == null && right == null)
            return true;

        return
                left != null && right != null
                        && left.data == right.data
                        && isSame(left.left, right.right)
                        && isSame(left.right, right.left);
    }

    public boolean isSameTree(Tree p, Tree q) {
        if(p == null && q== null)
            return true;
        return p != null && q != null
                        && p.data == q.data
                        && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public Tree invertTree(Tree root) {

        if(root == null)
            return null;

        Tree left = invertTree(root.left);
        Tree right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

}

@Data
@RequiredArgsConstructor
@AllArgsConstructor
class Tree {
    final double data;
    Tree left;
    Tree right;
}