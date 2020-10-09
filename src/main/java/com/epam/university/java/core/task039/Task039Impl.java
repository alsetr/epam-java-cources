package com.epam.university.java.core.task039;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Task039Impl implements Task039 {

    class Node  {
        int sum;
        String code;

        public Node(int sum) {
            this.sum = sum;
        }

        void buildCode(String code) {
            this.code = code;
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    class LeafNode extends Node {
        char symbol;

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }

    @Override
    public Map<Character, String> getEncoding(Map<Character, Integer> charFrequencies) {
        Map<Character, Node> map = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                if (node.sum == t1.sum) {
                    if ((node instanceof LeafNode) ^ (t1 instanceof LeafNode)) {
                        if ((node instanceof LeafNode)) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else if ((node instanceof LeafNode) && (t1 instanceof LeafNode)) {
                        return (((LeafNode) node).symbol - ((LeafNode) t1).symbol);
                    }
                }
                return Integer.compare(node.sum, t1.sum);
            }
        });
        for (Map.Entry<Character, Integer> entry : charFrequencies.entrySet()) {
            Node node = new LeafNode(entry.getKey(), entry.getValue());
            queue.add(node);
            map.put(entry.getKey(), node);
        }
        while (queue.size() > 1) {
            Node node1;
            Node node2;
            if (queue.size() == map.size()) {
                node1 = queue.poll();
                node2 = queue.poll();
                if (node1.sum == node2.sum) {
                    queue.add(new InternalNode(node2, node1));
                } else {
                    queue.add(new InternalNode(node1, node2));
                }
                continue;
            }
            node1 = queue.poll();
            node2 = queue.poll();
            queue.add(new InternalNode(node1, node2));
        }
        queue.poll().buildCode("");
        Map<Character, String> result = new HashMap<>();
        for (Map.Entry<Character, Node> entry : map.entrySet()) {
            result.put(entry.getKey(), entry.getValue().code);
        }
        return result;
    }

    @Override
    public String getEncodedString(Map<Character, Integer> charFrequencies, String string) {
        Map<Character, String> coder = getEncoding(charFrequencies);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            sb.append(coder.get(string.charAt(i)));
        }
        return sb.toString();
    }

    @Override
    public String getDecodedString(Map<Character, Integer> charFrequencies, String encodedString) {
        Map<Character, String> coder = getEncoding(charFrequencies);
        Map<String, Character> encoder = new HashMap<>();
        for (Map.Entry<Character, String> entry : coder.entrySet()) {
            encoder.put(entry.getValue(), entry.getKey());
        }
        StringBuilder symbolCode = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedString.length(); i++) {
            symbolCode.append(encodedString.charAt(i));
            if (encoder.containsKey(symbolCode.toString())) {
                sb.append(encoder.get(symbolCode.toString()));
                symbolCode = new StringBuilder();
            }
        }
        return sb.toString();
    }
}
