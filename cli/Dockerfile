# Use the official lightweight Node.js image
FROM node:18-alpine as build

# Set the working directory to /app
WORKDIR /app

# Copy the package.json and package-lock.json files to the container
COPY package*.json ./

# Install dependencies
RUN npm install --legacy-peer-deps
RUN npm install -g @angular/cli

# Copy the rest of the app's source code to the container
COPY . .

# Build the Angular app
RUN npm run build --prod

# Expose port 80
EXPOSE 4200

# Start the app
CMD ng serve --host 0.0.0.0
