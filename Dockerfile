# Step 1: Use an ARM64-compatible Python base image
FROM arm64v8/python:3.9-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy all files from the current directory to the /app directory in the container
COPY . /app

# Step 4: Install the required dependencies from requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

# Step 5: Expose the port your app will listen on
EXPOSE 8080

# Step 6: Define the default command to run your app (change app.py if necessary)
CMD ["python", "app/app.py"]
