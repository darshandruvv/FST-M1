import pytest

@pytest.fixture
def wallet():
    return {"amount": 0}

@pytest.mark.parametrize("earned, spent, expected", [
    (30, 10, 20),
    (20, 2, 18),
])
def test_wallet_transactions(wallet, earned, spent, expected):
    
    assert wallet["amount"] == 0

   
    wallet["amount"] += earned

    
    wallet["amount"] -= spent


    assert wallet["amount"] == expected
