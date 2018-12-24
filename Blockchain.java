package blockchain; 

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private int difficulty;
    private List<Block> blocks;

    public Blockchain(int difficulty) {
        this.difficulty = difficulty;
        blocks = new ArrayList<>();
        Block Genesis = new Block(0,System.currentTimeMillis(), null, "Genesis Block");
        Genesis.mineBlock(difficulty);
        blocks.add(Genesis);
    }

    public int getDifficulty() {
        return difficulty;
    }
    
    public Block latestBlock(){
        return blocks.get(blocks.size() - 1);
    }
    
    public Block newBlock(String data){
        Block latestBlock = latestBlock();
        Block newBlock = new Block(latestBlock.getIndex() + 1, System.currentTimeMillis(),
              latestBlock.getHash(), data);
        return newBlock;
    }
    
    public void addBlock(Block newBlock){
        if(newBlock != null){
            newBlock.mineBlock(difficulty);
            blocks.add(newBlock);
        }
    }
    
    public boolean isFirstBlockValid(){
        Block firstBlock = blocks.get(0);
        
        if(firstBlock.getIndex() != 0)
            return false;
        if(firstBlock.getPreviousHash() != null)
            return false;
        if(firstBlock.getHash() == null ||
               !Block.calculateHash(firstBlock).equals(firstBlock.getHash())){
            return false;
        }
        
        return true;
    }
    
    public boolean isNewBlockValid(Block newBlock, Block previousBlock){
        if(newBlock != null && previousBlock != null){
            if(previousBlock.getIndex() + 1 != newBlock.getIndex()){
                return false;
            }
            if(newBlock.getPreviousHash() == null || !newBlock.getPreviousHash().equals(previousBlock.getHash())){
                return false;
            }
            if(newBlock.getHash() == null || !Block.calculateHash(newBlock).equals(newBlock.getHash())){
                return false;
            }
            return true;
        }
        return false;
    }
    
    public boolean isBlockchainValid(){
        if(!isFirstBlockValid()){
            return false;
        }
        
        for (int i = 1; i < blocks.size(); i++) {
            Block newBlock = blocks.get(i);
            Block prevBlock = blocks.get(i-1);
            
            if(!isNewBlockValid(newBlock, prevBlock)){
                return false;
            }            
        }
        return true;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        
        for(Block block: blocks){
            builder.append(block).append("\n");
        }
        
        return builder.toString();
    }
}
   
