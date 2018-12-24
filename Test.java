package blockchain;


public class Test {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain(4);
        blockchain.addBlock(blockchain.newBlock("Some transactions"));
        blockchain.addBlock(blockchain.newBlock("Some more transactions"));
        blockchain.addBlock(blockchain.newBlock("A bit more transactions"));
        
        System.out.println(blockchain);
        System.out.println("Blockchain valid? " + blockchain.isBlockchainValid() + "\n");
        
        //adding a curropt block to verify our validation method is working properly
        blockchain.addBlock(new Block(7, System.currentTimeMillis(), "something false", "Invalid Block"));
        System.out.println(blockchain);
        System.out.println("Blockchain valid? " + blockchain.isBlockchainValid() + "\n");
    }
} 
