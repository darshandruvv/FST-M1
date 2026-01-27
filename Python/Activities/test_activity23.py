import pytest

# @pytest.fixture
# def number_list():
#     return list(range(11))   # 0 to 10

def test_sum_of_numbers(number_list):
    assert sum(number_list) == 55
