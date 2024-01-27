import Levenshtein

class ApproximateSearch:
    def __init__(self, filename):
        self.words = self.read_file(filename)

    def read_file(self, filename):
        with open(filename, 'r') as file:
            words = file.read().split()
        return words

    def find_similar_strings(self, query, k=5):
        distances = [(word, Levenshtein.distance(query, word)) for word in self.words]
        sorted_distances = sorted(distances, key=lambda x: x[1])
        suggestions = [item[0] for item in sorted_distances[:k]]
        return suggestions

def main():
    filename = r'C:\Users\lenovo\Downloads\file_management_system (1)/robots.txt'  # Change to the actual file path
    search_engine = ApproximateSearch(filename)

    while True:
        user_input = input("Input>> ").strip().lower()
        if user_input == 'exit':
            break

        suggestions = search_engine.find_similar_strings(user_input)
        print("Output >>", ", ".join(suggestions))

if __name__ == "__main__":
    main()
