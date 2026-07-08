DECLARE
    CURSOR loan_cursor IS
        SELECT c.Name, l.LoanID, l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN

    FOR loan_record IN loan_cursor LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || loan_record.Name ||
            ', your Loan ID ' || loan_record.LoanID ||
            ' is due on ' || loan_record.DueDate
        );

    END LOOP;

END;
/
