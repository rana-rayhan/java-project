package trie;

public class TrieDSA {
    public static class Trie {
        static Node root = new Node();
        public static String ans = "";

        public void insert(String word) {
            Node currNode = root;

            for(int i = 0; i < word.length(); ++i) {
                int idx = word.charAt(i) - 97;
                if (currNode.children[idx] == null) {
                    currNode.children[idx] = new Node();
                }

                if (word.length() - 1 == i) {
                    currNode.children[idx].eow = true;
                }

                currNode = currNode.children[idx];
            }

        }

        public static boolean search(String word) {
            Node currNode = root;

            for(int i = 0; i < word.length(); ++i) {
                int idx = word.charAt(i) - 97;
                Node node = currNode.children[idx];
                if (node == null) {
                    return false;
                }

                if (word.length() - 1 == i && !node.eow) {
                    return false;
                }

                currNode = node;
            }

            return true;
        }

        public static boolean startsWith(String word) {
            Node currNode = root;

            for(int i = 0; i < word.length(); ++i) {
                int idx = word.charAt(i) - 97;
                Node node = currNode.children[idx];
                if (node == null) {
                    return false;
                }

                currNode = node;
            }

            return true;
        }

        public static boolean wordBreak(String word) {
            if (word.length() == 0) {
                return true;
            } else {
                for(int i = 1; i <= word.length(); ++i) {
                    String firstPart = word.substring(0, i);
                    String secPart = word.substring(i);
                    if (search(firstPart) && wordBreak(secPart)) {
                        return true;
                    }
                }

                return false;
            }
        }

        public static int countNode(Node root) {
            if (root == null) {
                return 0;
            } else {
                int count = 0;

                for(int i = 0; i < 26; ++i) {
                    if (root.children[i] != null) {
                        count += countNode(root.children[i]);
                    }
                }

                return count + 1;
            }
        }

        public static void longestWord(Node root, StringBuilder sb) {
            if (root != null) {
                for(int i = 0; i < 26; ++i) {
                    if (root.children[i] != null && root.children[i].eow) {
                        sb.append((char)(i + 97));
                        if (ans.length() < sb.length()) {
                            ans = sb.toString();
                        }

                        longestWord(root.children[i], sb);
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }

            }
        }

        public static class Node {
            Node[] children = new Node[26];
            boolean eow = false;

            Node() {
                for(int i = 0; i < 26; ++i) {
                    this.children[i] = null;
                }

            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] var3 = words;
        int var4 = words.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String s = var3[var5];
            trie.insert(s);
        }

        TrieDSA.Trie.longestWord(TrieDSA.Trie.root, new StringBuilder());
        System.out.println(TrieDSA.Trie.ans);
        System.out.println(TrieDSA.Trie.countNode(TrieDSA.Trie.root));
    }

}
