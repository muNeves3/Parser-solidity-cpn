// SPDX-License-Identifier: GPL-3.0

pragma solidity ^0.8.4;

contract ControleEstoque {
    uint[10] public estoque;

    constructor() {}

    function abastecer(uint idProduto, uint qtd) public {
        estoque[idProduto] += qtd;
    }
}