pragma solidity ^0.8.0;

contract SimpleContract {
    uint256 public balance;
    address public owner;
    
    constructor() {
        owner = msg.sender;
        balance = 0;
    }
    
    function deposit(uint256 amount) public {
        require(amount > 0, "Amount must be greater than 0");
        require(msg.sender == owner, "Only owner can deposit");
        
        balance += amount;
    }
    
    function withdraw(uint256 amount) public {
        require(amount > 0, "Amount must be greater than 0");
        require(balance >= amount, "Insufficient balance");
        require(msg.sender == owner, "Only owner can withdraw");
        
        balance -= amount;
    }
    
    function getBalance() public view returns (uint256) {
        return balance;
    }
}
