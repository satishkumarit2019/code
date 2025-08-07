from dotenv import load_dotenv
import os
from langchain_openai import OpenAI, ChatOpenAI
from langchain.schema import HumanMessage
from langchain_openai import AzureChatOpenAI
from openai import OpenAI
from pydantic import BaseModel
from typing_extensions import TypedDict

class CalculatorInput(BaseModel):
    expression: str
    description: str

class CalculatorOutput(BaseModel):
    result: str
    description: str


# Load environment variables
load_dotenv(override=True, dotenv_path=os.path.join(os.path.dirname("C:\code\privatedata\\"), '.env'))


def get_azure_llm():
    """
    Returns an AzureChatOpenAI LLM instance with preset configuration.
    """

    print("\033[91m⚠️  DO NOT USE THIS AZURE OPENAI UNLESS YOU HAVE URGENT NEEDS ⚠️\033[0m")

    return AzureChatOpenAI(
        azure_deployment=os.getenv('AZURE_OPENAI_API_DEPLOYMENT'),
        azure_endpoint=os.getenv('AZURE_OPENAI_API_ENDPOINT'),
        api_version=os.getenv('AZURE_OPENAI_API_VERSION'),
        api_key=os.getenv('AZURE_OPENAI_API_KEY'),
        temperature=0.7,
    )

def get_personal_azure_llm():
    """
    Returns an AzureChatOpenAI LLM instance with preset configuration.
    """

    print("\033[93m⚠️  USING MY PERSONAL AZURE OPENAI ⚠️\033[0m")


    return AzureChatOpenAI(
        azure_deployment=os.getenv('MY_PERSONAL_AZURE_OPENAI_DEPLOYMENT'),
        azure_endpoint=os.getenv('MY_PERSONAL_AZURE_OPENAI_ENDPOINT'),
        api_version=os.getenv('MY_PERSONAL_AZURE_OPENAI_API_VERSION'),
        api_key=os.getenv('MY_PERSONAL_AZURE_OPENAI_API_KEY'),
        temperature=0.7,
    )

def get_mock_chat_openai_llm():
    """
    Returns a mock ChatOpenAI LLM instance for testing purposes using LangChain.
    Better for chat-based interactions.
    """

    print("\033[92m✅ USING MOCK OPENAI LLM (NO COST) ✅\033[0m")

    return ChatOpenAI(
        api_key="any-key-works",
        base_url="http://localhost:8888/v1",
        model="gpt-3.5-turbo",  # ChatOpenAI uses 'model'
        temperature=0.7
    )





def test_get_azure_llm():
    """
    Test function to invoke the AzureChatOpenAI LLM with a sample message.
    """
    model = get_azure_llm()
    response = model.invoke([HumanMessage(content="Tell me a fun fact about space.")])
    print(f"Paid Azure LLM Response: {response.content}")

def test_my_llm():
    """
    Test function to invoke the personal AzureChatOpenAI LLM with a sample message.
    """
    model = get_personal_azure_llm()
    response = model.invoke([HumanMessage(content="What is the capital of India")])
    print(f"Personal Azure LLM Response: {response.content}")


    
def test_get_mock_openai_llm():
    """
    Test function to invoke the mock OpenAI LLM with a sample message.
    """
    try:      
        chat_model = get_mock_chat_openai_llm()
        chat_response = chat_model.invoke([HumanMessage(content="Tell me a fun fact about space.")])
        print(f"Mock ChatOpenAI Response: {chat_response.content}")        
    except Exception as e:
        print(f"Error testing mock LLM: {e}")

def get_llm(llm: str = "mock"):
    """
    Returns an OpenAI LLM instance with preset configuration.
    """
    llm= llm.lower()
    enabled: bool = False
    #enabled: bool = True
    if llm == "com":       
        if not enabled:
            print("\033[91m⚠️  DO NOT USE THIS AZURE OPENAI UNLESS YOU HAVE URGENT NEEDS ⚠️\033[0m")          
            print("\033[91m⚠️  NOT ENABLED! check it in \033[4m/c:/code/udmy/ai_agents/agents/4_langgraph/myutil.py\033[0m ⚠️\033[0m")  
            return None            
        return get_azure_llm()
    elif llm == "my":
        return get_personal_azure_llm()
    elif llm == "mock":
        return get_mock_chat_openai_llm()
    else:
        raise ValueError(f"Unknown LLM type: {llm}. Use 'com', 'my', or 'mock'.")
    

# Test the functions
if __name__ == "__main__":
    #test_get_azure_llm()
    #test_get_mock_openai_llm()    
    test_my_llm()
    #Example usage:
    #get_llm("my")
    #get_llm("mock")  # For mock LLM
    #get_llm("com")  # For paid Azure OpenAI LLM
    # get_llm("my")   # For personal Azure OpenAI LLM
    # get_llm("unknown")  # Raises ValueError
    # get_llm("mock")  # For mock LLM

