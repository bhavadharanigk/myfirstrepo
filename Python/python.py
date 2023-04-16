import pyodbc

# Set up a connection to the SQL Server database
connection = pyodbc.connect(
    'Driver={SQL Server};'
    'Server=TESLA;'
    'Database=helloworld;'
    'Trusted_Connection=yes;'
)

# Define the SELECT query
query = 'SELECT * FROM employees'

# Execute the query and fetch the results
with connection.cursor() as cursor:
    cursor.execute(query)
    results = cursor.fetchall()

# Print the results
for row in results:
    print(row)
