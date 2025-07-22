package com.techcrack;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffManCoding {
    Map<Character, String> encode;
    Map<String, Character> decode;

    class Node implements Comparable<Node>{
        Character data;
        Integer cost;
        Node left;
        Node right;

        Node(Character data, Integer cos) {
            this.data = data;
            this.cost =  cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    HuffManCoding(String data) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < data.length(); ++i) {
            char ch = data.charAt(i);

            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> emp : freqMap.entrySet()) {
            Node node = new Node(emp.getKey(), emp.getValue());

            minHeap.offer(node);
        }

        while (minHeap.size() != 1) {
            Node first = minHeap.poll();
            Node second = minHeap.poll();

            Node cur = new Node('\0', first.cost + second.cost);

            minHeap.offer(cur);
        }

        Node root = minHeap.poll();
        encode = new HashMap<>();
        decode = new HashMap<>();

        initEncodeDecode(root, "");
    }

    public void initEncodeDecode(Node node, String path) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            encode.put(node.data, path);
            decode.put(path, node.data);
        }

        initEncodeDecode(node.left, path + '0');
        initEncodeDecode(node.right, path + '1');
    }

    public String encodeDataStr(String data) {
        StringBuilder decode = new StringBuilder();

        for (int i = 0; i < data.length(); ++i) {
            char ch = data.charAt(i);

            decode.append(encode.get(ch));
        }

        return decode.toString();
    }

    public BitSet encode(String data) {
        BitSet bitSet = new BitSet();
        int index = 0;

        for (int i = 0; i < data.length(); ++i) {
            char ch = data.charAt(i);

            for (int j = 0; j < encode.get(ch).length(); ++j) {
                if (encode.get(ch).charAt(j) == '1') {
                    bitSet.set(index);
                }

                index++;
            }
        }

        return bitSet;
    }

    public String decode(BitSet bitSet, int length) {
        StringBuilder key = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            key.append(bitSet.get(i) ? '1' : '0');

            if (decode.containsKey(key.toString())) {
                ans.append(decode.get(key.toString()));
                key.setLength(0);
            }
        }

        return ans.toString();
    }

    public String decodeDataStr(String decode) {
        StringBuilder encode = new StringBuilder();
        String key = "";

        for (int i = 0; i < decode.length(); ++i) {
            key += decode.charAt(i);

            if (this.decode.containsKey(key)) {
                encode.append(this.decode.get(key));
                key = "";
            }
        }

        return encode.toString();
    }
}
