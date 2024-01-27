import ast

def safe_eval(expression):
    try:
        parsed_expr = ast.parse(expression, mode='eval')
        result = eval(compile(parsed_expr, filename="<string>", mode='eval'))
        return str(result)
    except Exception as e:
        return f"Error: {e}"

def process_file(input_file, output_file):
    with open(input_file, 'r') as infile:
        expressions = infile.readlines()

    with open(output_file, 'w') as outfile:
        for expression in expressions:
            expression = expression.strip()
            result = safe_eval(expression)
            outfile.write(f"{expression}={result}\n")

def main():
    input_file = 'C:\Users\lenovo\Downloads\Arthemetic\input.txt'  # Change to the actual file path
    output_file = 'C:\Users\lenovo\Downloads\Arthemetic\output.txt'  # Change to the desired output file path

    process_file(input_file, output_file)
    print(f"Expressions solved. Results written to {output_file}")

if __name__ == "__main__":
    main()
