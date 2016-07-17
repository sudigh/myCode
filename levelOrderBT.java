/* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
   void LevelOrder(Node root)
   {
       Queue<Node> que = new LinkedList<Node>();
       if (root != null) {
           que.add(root);
       }
       while (!que.isEmpty()) {
           Node current = que.poll();
           System.out.print(current.data + " ");
           if(current.left != null)
               que.add(current.left);
           if(current.right != null)
               que.add(current.right);   
       }
      
   }
