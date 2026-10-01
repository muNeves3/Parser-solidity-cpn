contract testetap {
    private uint256 balanceA = 0;
    private uint256 balanceB = 0;

    function splitPayment(uint256 amount) public {
        uint256 half = amount / 2;
        uint256 remainder = amount - half; 
        
        balanceA = balanceA + half;
        balanceB = balanceB + remainder;
    }
}