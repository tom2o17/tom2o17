import unittest

from expenses import *

class Expenses_Test(unittest.TestCase):

    def setUp(self):
        """The setUp function runs before every test function."""

        # load expenses files
        self.expenses = {}
        import_expenses(self.expenses, 'expenses.txt')
        import_expenses(self.expenses, 'expenses_2.txt')

    def test_import_expenses(self):

        # test existing total expenses
        self.assertAlmostEqual(45, self.expenses['clothes'])
        self.assertAlmostEqual(12.40, self.expenses['coffee'])
        self.assertAlmostEqual(135.62, self.expenses['entertainment'])

    def test_get_expense(self):

        # test getting expenses based on expense type
        self.assertAlmostEqual(12.40, get_expense(self.expenses, "coffee"))

        # test non-existing expense types
        self.assertEqual(None, get_expense(self.expenses, "phone"))

        # TODO insert 2 additional test cases
        #  Hint(s): Test both existing and non-existing expense types
        self.assertEqual(825.00, get_expense(self.expenses, 'rent'))
        self.assertEqual(None, get_expense(self.expenses, 'beer'))


    def test_add_expense(self):

        # test adding a new expense
        add_expense(self.expenses, "fios", 84.5)
        self.assertAlmostEqual(84.5, self.expenses.get("fios"))

        # TODO insert 2 additional test cases
        #  Hint(s): Test adding to existing expenses
        add_expense(self.expenses, 'coffee', 20)
        self.assertAlmostEqual(32.40, self.expenses.get('coffee'))

        add_expense(self.expenses, 'rent', 100)
        self.assertAlmostEqual(925.00, self.expenses.get('rent'))



    def test_deduct_expense(self):

        # test deducting from expense
        deduct_expense(self.expenses, "coffee", .99)
        self.assertAlmostEqual(11.41, self.expenses.get("coffee"))

        # test deducting from expense
        deduct_expense(self.expenses, "entertainment", 100)
        self.assertAlmostEqual(35.62, self.expenses.get("entertainment"))

        # TODO insert 2 additional test cases
        #  Hint(s):
        #   Test deducting too much from expense
        #   Test deducting from non-existing expense

        # Deducting too much
        self.assertRaises(RuntimeError, deduct_expense, self.expenses, 'coffee', 1000)

        # Deducting from a non-existent expense
        self.assertRaises(RuntimeError, deduct_expense, self.expenses, 'beer', 1000)




    def test_update_expense(self):

        #test updating an expense
        update_expense(self.expenses, "clothes", 19.99)
        self.assertAlmostEqual(19.99, get_expense(self.expenses, "clothes"))

        # TODO insert 2 additional test cases
        #  Hint(s):
        #   Test updating an expense
        #   Test updating a non-existing expense

        # Existing expense
        update_expense(self.expenses, 'rent', 500)
        self.assertAlmostEqual(500, get_expense(self.expenses, 'rent'))

        # A non existing expense
        update_expense(self.expenses, 'beer', 300)
        self.assertEqual(None, get_expense(self.expenses, 'beer'))


    def test_sort_expenses(self):

        # test sorting expenses by 'expense_type'
        expense_type_sorted_expenses = [('clothes', 45.0),
                                        ('coffee', 12.40),
                                        ('entertainment', 135.62),
                                        ('family', 32.45),
                                        ('food', 5.0),
                                        ('music', 324.0),
                                        ('rent', 825.0)]

        self.assertListEqual(expense_type_sorted_expenses, sort_expenses(self.expenses, "expense_type"))

        # TODO insert 1 additional test case
        #   Hint: Test sorting expenses by 'amount'

        # Sorting by 'amount'
        amount_sorted_expenses = [('rent', 825.0),
                                  ('music', 324.0),
                                  ('entertainment', 135.62),
                                  ('clothes', 45.0),
                                  ('family', 32.45),
                                  ('coffee', 12.40),
                                  ('food', 5.0)]

        self.assertListEqual(amount_sorted_expenses, sort_expenses(self.expenses, 'amount'))

if __name__ == '__main__':
    unittest.main(verbosity = 2)
