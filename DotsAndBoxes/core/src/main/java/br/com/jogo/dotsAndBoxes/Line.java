package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Line extends Elements {
    private ShapeRenderer shape;
    private float keepPositionX, keepPositionY;
    private Color color;
    private boolean canClick, isHovered, clicked;

    public Line() {
        shape = new ShapeRenderer();
        keepPositionY = 0f;
        keepPositionX = 0f;
        color = Color.DARK_GRAY;
        canClick = true;
        isHovered = false;
        clicked = false;
    }

    public void createLine(float positionX, float positionX2, float positionY, float positionY2) {
        setPositionX(positionX);
        keepPositionX = getPositionX();
        setPositionY(positionY);
        keepPositionY = getPositionY();

        setPositionX(positionX2);
        setPositionY(positionY2);

    }

    public void renderLine() {
        shape.begin(ShapeType.Filled);

        if (isHovered && canClick) {
            shape.setColor(Color.SKY); // cor de destaque ao passar o mouse
        } else {
            shape.setColor(color);
        }

        shape.rectLine(keepPositionX, keepPositionY, getPositionX(), getPositionY(), 5f);
        shape.end();
    }

    public void disposeLine() {
        shape.dispose();
    }

    public void setHovered(boolean hovered) {
        this.isHovered = hovered;
    }

    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    public boolean getCanClick() {
        return canClick;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean getClicked() {
        return clicked;
    }

    public boolean isClicked(float mouseX, float mouseY) {
        float lineStartX = keepPositionX;
        float lineStartY = keepPositionY;
        float lineEndX = getPositionX();
        float lineEndY = getPositionY();

        float distanceToLine = distanceFromPointToLine(mouseX, mouseY, lineStartX, lineStartY, lineEndX, lineEndY);

        return distanceToLine < 10f;
    }

    public float distanceFromPointToLine(
            float pointX, float pointY,
            float lineStartX, float lineStartY,
            float lineEndX, float lineEndY) {

        float projectionFactor = calculateProjectionFactor(
                pointX, pointY, lineStartX, lineStartY, lineEndX, lineEndY);

        float[] closestPoint = getClosestPointOnSegment(
                lineStartX, lineStartY, lineEndX, lineEndY, projectionFactor);

        return calculateDistance(pointX, pointY, closestPoint[0], closestPoint[1]);
    }

    private float calculateProjectionFactor(
            float pointX, float pointY,
            float lineStartX, float lineStartY,
            float lineEndX, float lineEndY) {
        float vectorToStartX = pointX - lineStartX;
        float vectorToStartY = pointY - lineStartY;

        float lineVectorX = lineEndX - lineStartX;
        float lineVectorY = lineEndY - lineStartY;

        float dotProduct = vectorToStartX * lineVectorX + vectorToStartY * lineVectorY;
        float lineLengthSquared = lineVectorX * lineVectorX + lineVectorY * lineVectorY;

        return (lineLengthSquared != 0f) ? (dotProduct / lineLengthSquared) : -1f;
    }

    private float[] getClosestPointOnSegment(
            float lineStartX, float lineStartY,
            float lineEndX, float lineEndY,
            float projectionFactor) {
        float closestX, closestY;

        if (projectionFactor < 0f) {
            closestX = lineStartX;
            closestY = lineStartY;
        } else if (projectionFactor > 1f) {
            closestX = lineEndX;
            closestY = lineEndY;
        } else {
            closestX = lineStartX + projectionFactor * (lineEndX - lineStartX);
            closestY = lineStartY + projectionFactor * (lineEndY - lineStartY);
        }

        return new float[] { closestX, closestY };
    }

    private float calculateDistance(float x1, float y1, float x2, float y2) {
        float deltaX = x1 - x2;
        float deltaY = y1 - y2;
        return (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

}
