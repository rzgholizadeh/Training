const cluster = require("cluster");

// is the file being executed in master mode?
if (cluster.isMaster) {
	// cause index.js to be executed again but in child mode
	cluster.fork();
	cluster.fork();
	cluster.fork();
	cluster.fork();
} else {
	// a child process to act like a server
	const express = require("express");
	const app = express();

	function doWork(duration) {
		const start = Date.now();
		while (Date.now() - start < duration) {}
	}

	app.get("/", (req, res) => {
		doWork(5000);
		res.send("The slow option!");
	});

	app.get("/fast", (req, res) => {
		res.send("The fast option!");
	});

	app.listen(3000);
}
