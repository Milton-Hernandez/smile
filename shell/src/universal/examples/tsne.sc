// t-SNE on MNIST

var mnist = read.csv(smile.util.Paths.getTestData("mnist/mnist2500_X.txt").toString, ' ', false).toArray
val labels = read.csv(smile.util.Paths.getTestData("mnist/mnist2500_labels.txt").toString, header=false).column(0).toIntArray

val pca = new PCA(mnist)
pca.setProjection(50)
val X = pca.project(mnist)

val perplexity = 20
val tsne = new TSNE(X, 2, perplexity, 200, 1000)

val window = plot(tsne.getCoordinates, labels, '@', Palette.COLORS)
window.canvas.setTitle("t-SNE of MNIST")
