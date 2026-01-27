import pytest
from activity21 import add, subtract, multiply, divide


def test_add():
    assert add(5, 3) == 8

def test_subtract():
    assert subtract(10, 4) == 6
@pytest.mark.activity
def test_multiply():
    assert multiply(2, 6) == 12
@pytest.mark.activity
def test_divide():
    assert divide(8, 2) == 4
