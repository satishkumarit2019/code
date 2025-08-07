from PyPDF2 import PdfReader
from myutil import get_llm
from docx import Document
import gradio as gr


# read ms word document
def read_word_file(file_path):
    doc = Document(file_path)
    text = []
    for para in doc.paragraphs:
        text.append(para.text)
    return "\n".join(text)

reader = PdfReader("data/expenses_data.pdf")
expenses = ""
for page in reader.pages:
    text = page.extract_text()
    if text:
        expenses += text

print("PDF read successfully.")
print(expenses[:500])  # Print the first 500 characters for verification



llm = get_llm("My")
llm_response = llm.invoke("What is the capital of France?")
print(f"LLM Response: {llm_response.content}")

name = "IT Financial Assistant of Satish Kumar"

system_prompt = f"""You are a financial assistant chatbot designed to help the user analyze and understand their domestic expenses. 
You have access to structured data provided by the user, including categories like 
groceries, utilities, rent, travel, entertainment, and miscellaneous expenses. 
Your role is to:

1. Answer questions about past expenses, trends, and category-wise breakdowns.
2. Provide insights such as monthly averages, highest/lowest spending, and comparisons across time periods.
3. Forecast future expenses using historical data and simple predictive logic.
4. Maintain clarity and precision in your responses, using charts or tables when helpful.
5. Ask for clarification if the user’s query is ambiguous or if more data is needed.
6. Always respond in a friendly, informative, and concise manner. If the user uploads new data, incorporate it into your analysis. Do not make assumptions beyond the data provided."""

system_prompt += f"\n\n## Expenses data is:\n{expenses}"
system_prompt += f"With this context, please chat with the user, always staying in character as {name}."



def chat(message, history):
    #print(f"Received message: {message}")
    #print(f"History: {history}")
    # Build messages list, flattening history if present and skipping None
    messages = [{"role": "system", "content": system_prompt}]
    #if history:
    #    messages.extend(history)
    messages.append({"role": "user", "content": message})
    response = llm.invoke(messages)

    #print(f"Response: {response.content}")
    return response.content


gr.ChatInterface(chat, type="messages").launch()