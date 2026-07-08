DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;
BEGIN

    FOR customer_record IN customer_cursor LOOP

        IF customer_record.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_record.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');

END;
/
