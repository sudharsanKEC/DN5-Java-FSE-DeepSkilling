DECLARE
    CURSOR customer_cursor IS
        SELECT c.CustomerID, c.Age, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID;
BEGIN
    FOR customer_record IN customer_cursor LOOP

        IF customer_record.Age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = customer_record.LoanID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');

END;
/
