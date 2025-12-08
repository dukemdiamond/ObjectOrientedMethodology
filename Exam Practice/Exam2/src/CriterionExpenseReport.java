import java.util.List;

public interface CriterionExpenseReport extends ExpenseReport
{
  List<Expense> findExpenses(Criteria criteria);
}